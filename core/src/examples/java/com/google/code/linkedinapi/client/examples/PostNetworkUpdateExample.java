/*
 * Copyright 2010-2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.linkedinapi.client.examples;

import java.util.EnumSet;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.UpdateComment;

/**
 * @author Nabeel Mukhtar
 *
 */
public class PostNetworkUpdateExample {

    /**
     * Consumer Key
     */
    private static final String CONSUMER_KEY_OPTION = "consumerKey";

    /**
     * Consumer Secret
     */
    private static final String CONSUMER_SECRET_OPTION = "consumerSecret";

    /**
     * Access Token
     */
    private static final String ACCESS_TOKEN_OPTION = "token";

    /**
     * Access Token Secret
     */
    private static final String ACCESS_TOKEN_SECRET_OPTION = "tokenSecret";

    /**
     * Status Text
     */
    private static final String UPDATE_TEXT_OPTION = "update";

    /**
     * Name of the help command line option.
     */
    private static final String HELP_OPTION = "help";

    /**
	 * @param args
	 */
	public static void main(String[] args) {
		Options options = buildOptions();
        try {
            CommandLine line = new BasicParser().parse(options, args);
            processCommandLine(line, options);
        } catch(ParseException exp ) {
            System.err.println(exp.getMessage());
            printHelp(options);
        }
	}

    /**
     * Process command line options and call the service.
     */
    private static void processCommandLine(CommandLine line, Options options) {
        if(line.hasOption(HELP_OPTION)) {
            printHelp(options);
        } else if(line.hasOption(CONSUMER_KEY_OPTION) && line.hasOption(CONSUMER_SECRET_OPTION)
        		&& line.hasOption(ACCESS_TOKEN_OPTION) && line.hasOption(ACCESS_TOKEN_SECRET_OPTION)) {
    		final String consumerKeyValue = line.getOptionValue(CONSUMER_KEY_OPTION);
    		final String consumerSecretValue = line.getOptionValue(CONSUMER_SECRET_OPTION);
    		final String accessTokenValue = line.getOptionValue(ACCESS_TOKEN_OPTION);
    		final String tokenSecretValue = line.getOptionValue(ACCESS_TOKEN_SECRET_OPTION);

    		final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
    		final LinkedInApiClient client = factory.createLinkedInApiClient(accessTokenValue, tokenSecretValue);

    		if (line.hasOption(UPDATE_TEXT_OPTION)) {
        		final String updateText = line.getOptionValue(UPDATE_TEXT_OPTION);
        		client.postNetworkUpdate(updateText);
        		System.out.println("Your update has been posted. Check the LinkedIn site for confirmation.");
    		}
    		System.out.println("Fetching your network updates of type:" + NetworkUpdateType.SHARED_ITEM);
    		Network network = client.getNetworkUpdates(EnumSet.of(NetworkUpdateType.SHARED_ITEM));
    		printResult(network);
        } else {
            printHelp(options);
        }
    }

	/**
     * Build command line options object.
     */
    private static Options buildOptions() {

        Options opts = new Options();

        String helpMsg = "Print this message.";
        Option help = new Option(HELP_OPTION, helpMsg);
        opts.addOption(help);

        String consumerKeyMsg = "You API Consumer Key.";
        OptionBuilder.withArgName("consumerKey");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(consumerKeyMsg);
        Option consumerKey = OptionBuilder.create(CONSUMER_KEY_OPTION);
        opts.addOption(consumerKey);

        String consumerSecretMsg = "You API Consumer Secret.";
        OptionBuilder.withArgName("consumerSecret");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(consumerSecretMsg);
        Option consumerSecret = OptionBuilder.create(CONSUMER_SECRET_OPTION);
        opts.addOption(consumerSecret);

        String accessTokenMsg = "You OAuth Access Token.";
        OptionBuilder.withArgName("accessToken");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(accessTokenMsg);
        Option accessToken = OptionBuilder.create(ACCESS_TOKEN_OPTION);
        opts.addOption(accessToken);

        String tokenSecretMsg = "You OAuth Access Token Secret.";
        OptionBuilder.withArgName("accessTokenSecret");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(tokenSecretMsg);
        Option accessTokenSecret = OptionBuilder.create(ACCESS_TOKEN_SECRET_OPTION);
        opts.addOption(accessTokenSecret);

        String updateMsg = "Text of the update.";
        OptionBuilder.withArgName("update");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(updateMsg);
        Option update = OptionBuilder.create(UPDATE_TEXT_OPTION);
        opts.addOption(update);

        return opts;
    }

    /**
     * Print help and usage.
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = PostNetworkUpdateExample.class.getName() + " <options>";
        String header = "\nAll options are required.";
        new HelpFormatter().printHelp(width, syntax, header, options, null, false);
    }

	private static void printResult(Network network) {
    	System.out.println("================================");
		System.out.println("Total updates fetched:" + network.getUpdates().getTotal());
		for (Update update : network.getUpdates().getUpdateList()) {
			System.out.println("-------------------------------");
			System.out.println(update.getUpdateKey() + ":" + update.getUpdateContent().getPerson().getFirstName() + " " + update.getUpdateContent().getPerson().getLastName() + "->" + update.getUpdateContent().getPerson().getCurrentShare().getComment());
			if (update.getUpdateComments() != null) {
				System.out.println("Total comments fetched:" + update.getUpdateComments().getTotal());
				for (UpdateComment comment : update.getUpdateComments().getUpdateCommentList()) {
					System.out.println(comment.getPerson().getFirstName() + " " + comment.getPerson().getLastName() + "->" + comment.getComment());				
				}
			}
		}
	}
}
