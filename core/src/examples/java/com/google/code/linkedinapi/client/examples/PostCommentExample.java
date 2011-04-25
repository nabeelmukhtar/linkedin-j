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

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;

/**
 * @author Nabeel Mukhtar
 *
 */
public class PostCommentExample {

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
     * Network Update ID
     */
    private static final String POST_ID_OPTION = "postId";

    /**
     * Comment Text
     */
    private static final String COMMENT_TEXT_OPTION = "comment";

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
        		&& line.hasOption(ACCESS_TOKEN_OPTION) && line.hasOption(ACCESS_TOKEN_SECRET_OPTION)
        		&& line.hasOption(POST_ID_OPTION) && line.hasOption(COMMENT_TEXT_OPTION)) {
    		final String consumerKeyValue = line.getOptionValue(CONSUMER_KEY_OPTION);
    		final String consumerSecretValue = line.getOptionValue(CONSUMER_SECRET_OPTION);
    		final String accessTokenValue = line.getOptionValue(ACCESS_TOKEN_OPTION);
    		final String tokenSecretValue = line.getOptionValue(ACCESS_TOKEN_SECRET_OPTION);
    		final String postId = line.getOptionValue(POST_ID_OPTION);
    		final String comment = line.getOptionValue(COMMENT_TEXT_OPTION);

    		final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
    		final LinkedInApiClient client = factory.createLinkedInApiClient(accessTokenValue, tokenSecretValue);

    		client.postComment(postId, comment);

    		System.out.println("The comment has been posted successfully. Check the LinkedIn site for confirmation.");
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

        String idMsg = "ID of the post on which to comment.";
        OptionBuilder.withArgName("postId");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(idMsg);
        Option id = OptionBuilder.create(POST_ID_OPTION);
        opts.addOption(id);

        String commentMsg = "Text of the comment.";
        OptionBuilder.withArgName("comment");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(commentMsg);
        Option comment = OptionBuilder.create(COMMENT_TEXT_OPTION);
        opts.addOption(comment);

        return opts;
    }

    /**
     * Print help and usage.
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = PostCommentExample.class.getName() + " <options>";
        String header = "\nAll options are required. Post ID must be a valid network update ID.";
        new HelpFormatter().printHelp(width, syntax, header, options, null, false);
    }
}
