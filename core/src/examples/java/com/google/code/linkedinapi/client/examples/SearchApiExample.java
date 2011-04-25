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
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.Parameter;
import com.google.code.linkedinapi.client.constant.LanguageCodes;
import com.google.code.linkedinapi.client.constant.RelationshipCodes;
import com.google.code.linkedinapi.client.enumeration.FacetField;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.Facet;
import com.google.code.linkedinapi.schema.FacetType;
import com.google.code.linkedinapi.schema.Facets;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.PeopleSearch;
import com.google.code.linkedinapi.schema.Person;

/**
 * @author Nabeel Mukhtar
 *
 */
public class SearchApiExample {

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
     * keywords
     */
    private static final String KEYWORDS_OPTION = "keywords";
    
    /**
     * name
     */
    private static final String NAME_OPTION = "name";
    
    /**
     * company
     */
    private static final String COMPANY_OPTION = "company";
    
    /**
     * is current company
     */
    private static final String CURRENT_COMPANY_OPTION = "current_company";
    
    /**
     * title
     */
    private static final String TITLE_OPTION = "title";
    
    /**
     * current-title
     */
    private static final String CURRENT_TITLE_OPTION = "current_title";
    
    /**
     * industry-code
     */
    private static final String INDUSTRY_CODE_OPTION = "industry_code";
    
    /**
     * search-location-type
     */
    private static final String SEARCH_LOCATION_TYPE_OPTION = "search_location_type";
    
    /**
     * country-code
     */
    private static final String COUNTRY_CODE_OPTION = "country_code";
    
    /**
     * postal-code
     */
    private static final String POSTAL_CODE_OPTION = "postal_code";
    
    /**
     * network
     */
    private static final String NETWORK_OPTION = "network";
    
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
    		
    		Map<SearchParameter, String> searchParameters = getSearchParameters(line);
    		
    		if(!searchParameters.isEmpty()) {
    			System.out.println("Searching for users.");
    			List<Parameter<FacetType, String>> facets = new ArrayList<Parameter<FacetType,String>>();
    			facets.add(new Parameter<FacetType, String>(FacetType.NETWORK, RelationshipCodes.OUT_OF_NETWORK_CONNECTIONS));
    			facets.add(new Parameter<FacetType, String>(FacetType.NETWORK, RelationshipCodes.SECOND_DEGREE_CONNECTIONS));
    			facets.add(new Parameter<FacetType, String>(FacetType.LANGUAGE, LanguageCodes.ENGLISH));
    			PeopleSearch people = client.searchPeople(searchParameters, EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.ID, ProfileField.HEADLINE), EnumSet.of(FacetField.NAME, FacetField.CODE, FacetField.BUCKET_NAME, FacetField.BUCKET_CODE, FacetField.BUCKET_COUNT), facets);
    			printResult(people.getPeople());
    			printResult(people.getFacets());
    		} else {
    			System.out.println("Searching for users.");
    			People people = client.searchPeople();
    			printResult(people);
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
        
        OptionBuilder.withArgName("keywords");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("keywords");
        opts.addOption(OptionBuilder.create(KEYWORDS_OPTION));
        
        OptionBuilder.withArgName("name");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("name");
        opts.addOption(OptionBuilder.create(NAME_OPTION));
        
        OptionBuilder.withArgName("company");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("company");
        opts.addOption(OptionBuilder.create(COMPANY_OPTION));
        
        OptionBuilder.withArgName("current-company");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("current-company");
        opts.addOption(OptionBuilder.create(CURRENT_COMPANY_OPTION));
        
        OptionBuilder.withArgName("title");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("title");
        opts.addOption(OptionBuilder.create(TITLE_OPTION));
        
        OptionBuilder.withArgName("current-title");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("current-title");
        opts.addOption(OptionBuilder.create(CURRENT_TITLE_OPTION));
        
        OptionBuilder.withArgName("industry-code");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("industry-code");
        opts.addOption(OptionBuilder.create(INDUSTRY_CODE_OPTION));
        
        OptionBuilder.withArgName("search-location-type");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("search-location-type");
        opts.addOption(OptionBuilder.create(SEARCH_LOCATION_TYPE_OPTION));
        
        OptionBuilder.withArgName("country-code");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("country-code");
        opts.addOption(OptionBuilder.create(COUNTRY_CODE_OPTION));
        
        OptionBuilder.withArgName("postal-code");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("postal-code");
        opts.addOption(OptionBuilder.create(POSTAL_CODE_OPTION));
        
        OptionBuilder.withArgName("network");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("network");
        opts.addOption(OptionBuilder.create(NETWORK_OPTION));
        
        return opts;
    }
    
    /**
     * Print help and usage.
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = SearchApiExample.class.getName() + " <options>";
        String header = MessageFormat.format("\nThe -{0}, -{1}, -{2} and -{3} options are required. All others are optional.", CONSUMER_KEY_OPTION, CONSUMER_SECRET_OPTION, ACCESS_TOKEN_OPTION, ACCESS_TOKEN_SECRET_OPTION);
        String footer = "\nIf you do not specify any of the other options, all the members of the user's network are returned.";
        new HelpFormatter().printHelp(width, syntax, header, options, footer, false);
    }
    
    /**
     * Print the result of API call.
     */
    private static void printResult(People people) {
    	System.out.println("================================");
    	System.out.println("Total search result:" + people.getCount());
    	for (Person person : people.getPersonList()) {
    		System.out.println(person.getId() + ":" + person.getFirstName() + " " + person.getLastName() + ":" + person.getHeadline());
    	}
	}
    
	private static void printResult(Facets facets) {
    	System.out.println("================================");
    	System.out.println("Total facet result:" + facets.getTotal());
    	for (Facet facet : facets.getFacetList()) {
    		System.out.println(facet.getName() + ":" + facet.getCode());
    	}
	}

    
    
    /**
     *
     */
	private static Map<SearchParameter, String> getSearchParameters(CommandLine line) {
		Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
		
		if (line.hasOption(KEYWORDS_OPTION)) {
			searchParameters.put(SearchParameter.KEYWORDS, line.getOptionValue(KEYWORDS_OPTION));
		}
		
		if (line.hasOption(NAME_OPTION)) {
			searchParameters.put(SearchParameter.FIRST_NAME, line.getOptionValue(NAME_OPTION));
		}
		
		if (line.hasOption(COMPANY_OPTION)) {
			searchParameters.put(SearchParameter.COMPANY_NAME, line.getOptionValue(COMPANY_OPTION));
		}
		
		if (line.hasOption(CURRENT_COMPANY_OPTION)) {
			searchParameters.put(SearchParameter.CURRENT_COMPANY, line.getOptionValue(CURRENT_COMPANY_OPTION));
		}
		
		if (line.hasOption(TITLE_OPTION)) {
			searchParameters.put(SearchParameter.TITLE, line.getOptionValue(TITLE_OPTION));
		}
		
		if (line.hasOption(CURRENT_TITLE_OPTION)) {
			searchParameters.put(SearchParameter.CURRENT_TITLE, line.getOptionValue(CURRENT_TITLE_OPTION));
		}
		
		if (line.hasOption(COUNTRY_CODE_OPTION)) {
			searchParameters.put(SearchParameter.COUNTRY_CODE, line.getOptionValue(COUNTRY_CODE_OPTION));
		}
		
		if (line.hasOption(POSTAL_CODE_OPTION)) {
			searchParameters.put(SearchParameter.POSTAL_CODE, line.getOptionValue(POSTAL_CODE_OPTION));
		}
		
		return searchParameters;
	}
}
