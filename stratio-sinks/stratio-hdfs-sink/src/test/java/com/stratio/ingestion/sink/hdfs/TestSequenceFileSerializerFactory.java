/**
 * Copyright (C) 2014 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stratio.ingestion.sink.hdfs;

import org.apache.flume.Context;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestSequenceFileSerializerFactory {

  @Test
  public void getTextFormatter() {
    SequenceFileSerializer formatter =
        SequenceFileSerializerFactory.getSerializer("Text", new Context());

    assertTrue(formatter != null);
    assertTrue(formatter.getClass().getName(),
        formatter instanceof HDFSTextSerializer);
  }

  @Test
  public void getWritableFormatter() {
    SequenceFileSerializer formatter =
        SequenceFileSerializerFactory.getSerializer("Writable", new Context());

    assertTrue(formatter != null);
    assertTrue(formatter.getClass().getName(),
        formatter instanceof HDFSWritableSerializer);
  }

  @Test
  public void getCustomFormatter() {
    SequenceFileSerializer formatter = SequenceFileSerializerFactory
      .getSerializer(
        "org.apache.flume.sink.hdfs.MyCustomSerializer$Builder", new Context());

    assertTrue(formatter != null);
    assertTrue(formatter.getClass().getName(),
        formatter instanceof MyCustomSerializer);
  }

}
