/*
 * Copyright 2004-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.dbutils.handlers;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.BaseTestCase;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * ColumnListHandlerTest
 */
public class ColumnListHandlerTest extends BaseTestCase {

    public ColumnListHandlerTest(String name) {
        super(name);
    }

    public void testHandle() throws SQLException {
        ResultSetHandler h = new ColumnListHandler();

        List results = (List) h.handle(this.rs);

        assertNotNull(results);
        assertEquals(ROWS, results.size());

        assertEquals("1", results.get(0));
        assertEquals("4", results.get(1));
    }

    public void testColumnIndexHandle() throws SQLException {
        ResultSetHandler h = new ColumnListHandler(2);
        List results = (List) h.handle(this.rs);

        assertNotNull(results);
        assertEquals(ROWS, results.size());

        assertEquals("2", results.get(0));
        assertEquals("5", results.get(1));
    }

    public void testColumnNameHandle() throws SQLException {
        ResultSetHandler h = new ColumnListHandler("Three");
        List results = (List) h.handle(this.rs);

        assertNotNull(results);
        assertEquals(ROWS, results.size());

        assertEquals("3", results.get(0));
        assertEquals("6", results.get(1));
    }

    public void testEmptyResultSetHandle() throws SQLException {
        ResultSetHandler h = new ColumnListHandler();
        List results = (List) h.handle(this.emptyResultSet);

        assertNotNull(results);
        assertTrue(results.isEmpty());
    }

}