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
package org.ballerinalang.model.expressions;

import org.ballerinalang.model.NodeLocation;
import org.ballerinalang.model.NodeVisitor;
import org.ballerinalang.model.WhiteSpaceDescriptor;

/**
 * {@link XMLCommentLiteral} represents an XML comment literal in Ballerina.
 *
 * @since 0.90
 */
public class XMLCommentLiteral extends XMLLiteral {

    private Expression content;

    public XMLCommentLiteral(NodeLocation location, WhiteSpaceDescriptor whiteSpaceDescriptor, Expression content) {
        super(location, whiteSpaceDescriptor);
        this.content = content;
    }

    public Expression getContent() {
        return content;
    }

    public void setContent(Expression content) {
        this.content = content;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Expression accept(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }
}