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

package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Recommendation;
import com.google.code.linkedinapi.schema.RecommendationType;
import com.google.code.linkedinapi.schema.Recommendee;
import com.google.code.linkedinapi.schema.Recommender;

public class RecommendationImpl
	extends BaseSchemaEntity
    implements Recommendation
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected RecommendationTypeImpl recommendationType;
    protected String recommendationSnippet;
    protected String recommendationText;
    protected RecommendeeImpl recommendee;
    protected RecommenderImpl recommender;
    protected String webUrl;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public RecommendationType getRecommendationType() {
        return recommendationType;
    }

    public void setRecommendationType(RecommendationType value) {
        this.recommendationType = ((RecommendationTypeImpl) value);
    }

    public String getRecommendationSnippet() {
        return recommendationSnippet;
    }

    public void setRecommendationSnippet(String value) {
        this.recommendationSnippet = value;
    }
    
    public String getRecommendationText() {
        return recommendationText;
    }

    public void setRecommendationText(String value) {
        this.recommendationText = value;
    }

    public Recommendee getRecommendee() {
        return recommendee;
    }

    public void setRecommendee(Recommendee value) {
        this.recommendee = ((RecommendeeImpl) value);
    }

    public Recommender getRecommender() {
        return recommender;
    }

    public void setRecommender(Recommender value) {
        this.recommender = ((RecommenderImpl) value);
    }
    
    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String value) {
        this.webUrl = value;
    }
    
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("id")) {
        		setId(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("recommendation-type")) {
    			RecommendationTypeImpl recommendationType = new RecommendationTypeImpl();
    			recommendationType.init(parser);
    			setRecommendationType(recommendationType);
        	} else if (name.equals("recommendation-snippet")) {
        		setRecommendationSnippet(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("recommendation-text")) {
        		setRecommendationText(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("web-url")) {
        		setWebUrl(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("recommendee")) {
    			RecommendeeImpl recommendee = new RecommendeeImpl();
    			recommendee.init(parser);
    			setRecommendee(recommendee);
        	} else if (name.equals("recommender")) {
    			RecommenderImpl recommender = new RecommenderImpl();
    			recommender.init(parser);
    			setRecommender(recommender);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "recommendation");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "recommendation-snippet", getRecommendationSnippet());
		XppUtils.setElementValueToNode(element, "recommendation-text", getRecommendationText());
		XppUtils.setElementValueToNode(element, "web-url", getWebUrl());
		if (getRecommendee() != null) {
			((RecommendeeImpl) getRecommendee()).toXml(serializer);
		}
		if (getRecommender() != null) {
			((RecommenderImpl) getRecommender()).toXml(serializer);
		}
		if (getRecommendationType() != null) {
			((RecommendationTypeImpl) getRecommendationType()).toXml(serializer);
		}
		serializer.endTag(null, "recommendation");
	}
}
