/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.ballerinalang.model.types;

import org.ballerinalang.model.SymbolScope;
import org.ballerinalang.model.values.BValue;

/**
 * {@code BValueType} represents a value type in Ballerina.
 *
 * @since 0.8.0
 */
public class BValueType extends BType {

    public BValueType(SymbolScope symbolScope) {
        super(symbolScope);
    }

    public BValueType(String typeName, String pkgPath, SymbolScope symbolScope, Class<? extends BValue> valueClass) {
        super(typeName, pkgPath, symbolScope, valueClass);
    }

    @Override
    public <V extends BValue> V getZeroValue() {
        return null;
    }

    @Override
    public <V extends BValue> V getEmptyValue() {
        return null;
    }

    @Override
    public TypeSignature getSig() {
        return null;
    }

    @Override
    public int getTag() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}