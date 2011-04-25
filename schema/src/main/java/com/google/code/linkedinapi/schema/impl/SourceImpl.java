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

package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.Application;
import com.google.code.linkedinapi.schema.ServiceProvider;
import com.google.code.linkedinapi.schema.Source;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceProvider",
    "application"
})
@XmlRootElement(name = "source")
public class SourceImpl
    implements Serializable, Source
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "service-provider", required = true, type = ServiceProviderImpl.class)
    protected ServiceProviderImpl serviceProvider;
    @XmlElement(required = true, type = ApplicationImpl.class)
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

}
