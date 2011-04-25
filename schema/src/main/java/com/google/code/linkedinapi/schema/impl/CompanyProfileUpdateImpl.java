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
import com.google.code.linkedinapi.schema.Action;
import com.google.code.linkedinapi.schema.CompanyProfileUpdate;
import com.google.code.linkedinapi.schema.Editor;
import com.google.code.linkedinapi.schema.ProfileField;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "editor",
    "action",
    "profileField"
})
@XmlRootElement(name = "company-profile-update")
public class CompanyProfileUpdateImpl
    implements Serializable, CompanyProfileUpdate
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = EditorImpl.class)
    protected EditorImpl editor;
    @XmlElement(required = true, type = ActionImpl.class)
    protected ActionImpl action;
    @XmlElement(name = "profile-field", required = true, type = ProfileFieldImpl.class)
    protected ProfileFieldImpl profileField;

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor value) {
        this.editor = ((EditorImpl) value);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action value) {
        this.action = ((ActionImpl) value);
    }

    public ProfileField getProfileField() {
        return profileField;
    }

    public void setProfileField(ProfileField value) {
        this.profileField = ((ProfileFieldImpl) value);
    }

}
