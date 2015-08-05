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

public enum SequenceFileSerializerType {
  Writable(com.stratio.ingestion.sink.hdfs.HDFSWritableSerializer.Builder.class),
  Text(com.stratio.ingestion.sink.hdfs.HDFSTextSerializer.Builder.class),
  Other(null);

  private final Class<? extends com.stratio.ingestion.sink.hdfs.SequenceFileSerializer.Builder> builderClass;

  SequenceFileSerializerType(
    Class<? extends com.stratio.ingestion.sink.hdfs.SequenceFileSerializer.Builder> builderClass) {
    this.builderClass = builderClass;
  }

  public Class<? extends com.stratio.ingestion.sink.hdfs.SequenceFileSerializer.Builder> getBuilderClass() {
    return builderClass;
  }

}

