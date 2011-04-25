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
import com.google.code.linkedinapi.schema.CompanyPersonUpdate;
import com.google.code.linkedinapi.schema.NewPosition;
import com.google.code.linkedinapi.schema.OldPosition;
import com.google.code.linkedinapi.schema.Person;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "person",
    "action",
    "oldPosition",
    "newPosition"
})
@XmlRootElement(name = "company-person-update")
public class CompanyPersonUpdateImpl
    implements Serializable, CompanyPersonUpdate
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = PersonImpl.class)
    protected PersonImpl person;
    @XmlElement(required = true, type = ActionImpl.class)
    protected ActionImpl action;
    @XmlElement(name = "old-position", required = true, type = OldPositionImpl.class)
    protected OldPositionImpl oldPosition;
    @XmlElement(name = "new-position", required = true, type = NewPositionImpl.class)
    protected NewPositionImpl newPosition;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action value) {
        this.action = ((ActionImpl) value);
    }

    public OldPosition getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(OldPosition value) {
        this.oldPosition = ((OldPositionImpl) value);
    }

    public NewPosition getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(NewPosition value) {
        this.newPosition = ((NewPositionImpl) value);
    }

}
