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
import com.google.code.linkedinapi.schema.ImAccount;
import com.google.code.linkedinapi.schema.ImAccountType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "imAccountType",
    "imAccountName"
})
@XmlRootElement(name = "im-account")
public class ImAccountImpl
    implements Serializable, ImAccount
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "im-account-type", required = true)
    protected ImAccountType imAccountType;
    @XmlElement(name = "im-account-name", required = true)
    protected String imAccountName;

    public ImAccountType getImAccountType() {
        return imAccountType;
    }

    public void setImAccountType(ImAccountType value) {
        this.imAccountType = value;
    }

    public String getImAccountName() {
        return imAccountName;
    }

    public void setImAccountName(String value) {
        this.imAccountName = value;
    }

}
