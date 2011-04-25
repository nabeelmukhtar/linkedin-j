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

import com.google.code.linkedinapi.schema.Application;
import com.google.code.linkedinapi.schema.ServiceProvider;
import com.google.code.linkedinapi.schema.Source;

public class SourceImpl
	extends BaseSchemaEntity
    implements Source
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected ServiceProviderImpl serviceProvider;
    protected ApplicationImpl application;

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider value) {
        this.serviceProvider = ((ServiceProviderImpl) value);
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application value) {
        this.application = ((ApplicationImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("service-provider")) {
        		ServiceProviderImpl sp = new ServiceProviderImpl();
    			sp.init(parser);
    			setServiceProvider(sp);
            } else if (name.equals("application")) {
            	ApplicationImpl app = new ApplicationImpl();
    			app.init(parser);
    			setApplication(app);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		serializer.startTag(null, "source");
		if (getServiceProvider() != null) {
			((ServiceProviderImpl) getServiceProvider()).toXml(serializer);
		}
		if (getApplication() != null) {
			((ApplicationImpl) getApplication()).toXml(serializer);
		}
		serializer.endTag(null, "source");
	}
    
}
