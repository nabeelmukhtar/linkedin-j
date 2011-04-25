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

/**
 * @author Nabeel Mukhtar
 *
 */
public class InvitationApiExample {

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
     * ID
     */
    private static final String ID_OPTION = "id";
    
    /**
     * Email
     */
    private static final String EMAIL_OPTION = "email";
    
    /**
     * First Name
     */
    private static final String FIRST_NAME_OPTION = "firstName";
    
    /**
     * First Name
     */
    private static final String LAST_NAME_OPTION = "lastName";
    
    /**
     * Subject
     */
    private static final String SUBJECT_OPTION = "subject";
    
    /**
     * Message
     */
    private static final String MESSAGE_OPTION = "message";
    
    /**
     * Message
     */
    private static final String AUTH_HEADER_OPTION = "authHeader";
    
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
        		&& line.hasOption(SUBJECT_OPTION) && line.hasOption(MESSAGE_OPTION)) {
    		final String consumerKeyValue = line.getOptionValue(CONSUMER_KEY_OPTION);
    		final String consumerSecretValue = line.getOptionValue(CONSUMER_SECRET_OPTION);
    		final String accessTokenValue = line.getOptionValue(ACCESS_TOKEN_OPTION);
    		final String tokenSecretValue = line.getOptionValue(ACCESS_TOKEN_SECRET_OPTION);
    		final String subject = line.getOptionValue(SUBJECT_OPTION);
    		final String message = line.getOptionValue(MESSAGE_OPTION);
    		
    		final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
    		final LinkedInApiClient client = factory.createLinkedInApiClient(accessTokenValue, tokenSecretValue);
    		
    		if(line.hasOption(ID_OPTION)) {
    			String idValue = line.getOptionValue(ID_OPTION);
    			System.out.println("Sending invite to user with id:" + idValue);
    			if (line.hasOption(AUTH_HEADER_OPTION)) {
    				String authHeader = line.getOptionValue(AUTH_HEADER_OPTION);
    				client.sendInviteById(idValue, subject, message, authHeader);
            		System.out.println("Your invitation has been sent. Check the LinkedIn site for confirmation.");
    			} else {
    				printHelp(options);
    			}
    		} else if (line.hasOption(EMAIL_OPTION)) {
    			String emailValue = line.getOptionValue(EMAIL_OPTION);
    			if (line.hasOption(FIRST_NAME_OPTION) && line.hasOption(LAST_NAME_OPTION)) {
        			System.out.println("Sending invite to user with email:" + emailValue);
        			String firstName = line.getOptionValue(FIRST_NAME_OPTION);
        			String lastName = line.getOptionValue(LAST_NAME_OPTION);
        			client.sendInviteByEmail(emailValue, firstName, lastName, subject, message);
            		System.out.println("Your invitation has been sent. Check the LinkedIn site for confirmation.");
    			} else {
    				printHelp(options);
    			}
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
        
        String subjectMsg = "Subject of the invitation.";
        OptionBuilder.withArgName("subject");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(subjectMsg);
        Option subject = OptionBuilder.create(SUBJECT_OPTION);
        opts.addOption(subject);
        
        String messageMsg = "Content of the invitation.";
        OptionBuilder.withArgName("message");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(messageMsg);
        Option message = OptionBuilder.create(MESSAGE_OPTION);
        opts.addOption(message);
        
        String idMsg = "ID of the user to whom invitation has to be sent.";
        OptionBuilder.withArgName("id");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(idMsg);
        Option id = OptionBuilder.create(ID_OPTION);
        opts.addOption(id);
        
        String emailMsg = "Email of the user to whom invitation has to be sent.";
        OptionBuilder.withArgName("email");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(emailMsg);
        Option email = OptionBuilder.create(EMAIL_OPTION);
        opts.addOption(email);
        
        String firstNameMsg = "First name of the user to whom invitation has to be sent.";
        OptionBuilder.withArgName("firstName");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(firstNameMsg);
        Option firstName = OptionBuilder.create(FIRST_NAME_OPTION);
        opts.addOption(firstName);
        
        String lastNameMsg = "Last name of the user to whom invitation has to be sent.";
        OptionBuilder.withArgName("lastName");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(lastNameMsg);
        Option lastName = OptionBuilder.create(LAST_NAME_OPTION);
        opts.addOption(lastName);
        
        String authHeaderMsg = "Auth Header of the user to whom invitation has to be sent.";
        OptionBuilder.withArgName("authHeader");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(authHeaderMsg);
        Option authHeader = OptionBuilder.create(AUTH_HEADER_OPTION);
        opts.addOption(authHeader);
        
        return opts;
    }
    
    /**
     * Print help and usage.
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = InvitationApiExample.class.getName() + " <options>";
        String header = MessageFormat.format("\nThe -{0}, -{1}, -{2} , -{3}, -{4} and -{5} options are required. You must also specify either -{6} or -{7} option.", CONSUMER_KEY_OPTION, CONSUMER_SECRET_OPTION, ACCESS_TOKEN_OPTION, ACCESS_TOKEN_SECRET_OPTION, SUBJECT_OPTION, MESSAGE_OPTION, ID_OPTION, EMAIL_OPTION);
        String footer = MessageFormat.format("\nIf you specify -{0} option, you must specify -{2} option. Alternatively if you specify -{1} option, you must specify -{3} and -{4} options.", ID_OPTION, EMAIL_OPTION, AUTH_HEADER_OPTION, FIRST_NAME_OPTION, LAST_NAME_OPTION);
        new HelpFormatter().printHelp(width, syntax, header, options, footer, false);
    }
}
