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

package com.google.code.linkedinapi.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for null.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType>
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="elementary"/>
 *     &lt;enumeration value="limited_working"/>
 *     &lt;enumeration value="professional_working"/>
 *     &lt;enumeration value="full_professional"/>
 *     &lt;enumeration value="native_or_bilingual"/>
 *     &lt;enumeration value="beginner"/>
 *     &lt;enumeration value="intermediate"/>
 *     &lt;enumeration value="advanced"/>
 *     &lt;enumeration value="expert"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ProficiencyLevelType {

    @XmlEnumValue("elementary")
    ELEMENTARY("elementary"),
    @XmlEnumValue("limited_working")
    LIMITED_WORKING("limited_working"),
    @XmlEnumValue("professional_working")
    PROFESSIONAL_WORKING("professional_working"),
    @XmlEnumValue("full_professional")
    FULL_PROFESSIONAL("full_professional"),
    @XmlEnumValue("native_or_bilingual")
    NATIVE_BILINGUAL("native_or_bilingual"),
    @XmlEnumValue("beginner")
    BEGINNER("beginner"),
    @XmlEnumValue("intermediate")
    INTERMEDIATE("intermediate"),
    @XmlEnumValue("advanced")
    ADVANCED("advanced"),
    @XmlEnumValue("expert")
    EXPERT("expert");
    private final String value;

    ProficiencyLevelType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProficiencyLevelType fromValue(String v) {
        for (ProficiencyLevelType c: ProficiencyLevelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
