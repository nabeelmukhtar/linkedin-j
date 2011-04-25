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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.MessageFormat;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import com.google.code.linkedinapi.schema.Person;

/**
 * @author Nabeel Mukhtar
 *
 */
public class OAuthAuthenticationExample {

    /**
     * Consumer Key
     */
    private static final String CONSUMER_KEY_OPTION = "consumerKey";
	
    /**
     * Consumer Secret
     */
    private static final String CONSUMER_SECRET_OPTION = "consumerSecret";
    
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
        } else if(line.hasOption(CONSUMER_KEY_OPTION) && line.hasOption(CONSUMER_SECRET_OPTION)) {
        	try {
        		final String consumerKeyValue = line.getOptionValue(CONSUMER_KEY_OPTION);
        		final String consumerSecretValue = line.getOptionValue(CONSUMER_SECRET_OPTION);
        		
        		final LinkedInOAuthService oauthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(consumerKeyValue, consumerSecretValue);
        		
        		System.out.println("Fetching request token from LinkedIn...");
        		
        		LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();
        		
                String authUrl = requestToken.getAuthorizationUrl();

                System.out.println("Request token: " + requestToken.getToken());
                System.out.println("Token secret: " + requestToken.getTokenSecret());
                System.out.println("Expiration time: " + requestToken.getExpirationTime());

                System.out.println("Now visit:\n" + authUrl
                        + "\n... and grant this app authorization");
                System.out.println("Enter the PIN code and hit ENTER when you're done:");

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String pin = br.readLine();

                System.out.println("Fetching access token from LinkedIn...");
                
                LinkedInAccessToken accessToken = oauthService.getOAuthAccessToken(requestToken, pin);

                System.out.println("Access token: " + accessToken.getToken());
                System.out.println("Token secret: " + accessToken.getTokenSecret());

        		final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
        		final LinkedInApiClient client = factory.createLinkedInApiClient(accessToken);
        		
    			System.out.println("Fetching profile for current user.");
    			Person profile = client.getProfileForCurrentUser();
    			printResult(profile);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
        
        return opts;
    }
    
    /**
     * Print help and usage.
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = OAuthAuthenticationExample.class.getName() + " <options>";
        String header = MessageFormat.format("\nBoth the -{0} and -{1} options are required.", CONSUMER_KEY_OPTION, CONSUMER_SECRET_OPTION);
        new HelpFormatter().printHelp(width, syntax, header, options, null, false);
    }
    
    /**
     * Print the result of API call.
     */
    private static void printResult(Person profile) {
    	System.out.println("================================");
    	System.out.println("Name:" + profile.getFirstName() + " " + profile.getLastName());
    	System.out.println("Headline:" + profile.getHeadline());
    	System.out.println("Summary:" + profile.getSummary());
    	System.out.println("Industry:" + profile.getIndustry());
    	System.out.println("Picture:" + profile.getPictureUrl());
	}
}
