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

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class HDFSTestWriterFactory extends HDFSWriterFactory {
  static final String TestSequenceFileType = "SequenceFile";
  static final String BadDataStreamType = "DataStream";

  // so we can get a handle to this one in our test.
  AtomicInteger openCount = new AtomicInteger(0);

  @Override
  public HDFSWriter getWriter(String fileType) throws IOException {
    if (fileType == TestSequenceFileType) {
      return new HDFSTestSeqWriter(openCount.incrementAndGet());
    } else if (fileType == BadDataStreamType) {
      return new HDFSBadDataStream();
    } else {
      throw new IOException("File type " + fileType + " not supported");
    }
  }
}
