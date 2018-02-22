// Copyright (c) 2018 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
//
// WSO2 Inc. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package ballerina.builtin;

@Description { value:"Releases the database connection."}
@Param { value:"dt: The table object" }
public native function <table dt> close ();

@Description { value:"Checks for a new row in the given table. If a new row is found, moves the cursor to it."}
@Param { value:"dt: The table object" }
@Return { value:"True if there is a new row; false otherwise" }
public native function <table dt> hasNext () (boolean);

@Description { value:"Retrives the current row and return a struct with the data in the columns"}
@Param { value:"dt: The table object" }
@Return { value:"The resulting row as a struct" }
public native function <table dt> getNext () (any);