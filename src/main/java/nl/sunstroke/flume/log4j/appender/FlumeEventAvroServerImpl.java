/**
 * Licensed to Cloudera, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Cloudera, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.sunstroke.flume.log4j.appender;

import java.io.IOException;

import com.cloudera.flume.handlers.avro.AvroFlumeEvent;
import com.cloudera.flume.handlers.avro.FlumeEventAvroServer;
import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.HttpServer;
import org.apache.avro.ipc.specific.SpecificResponder;
/**
 * This implements the AvroEventServer.
 */
public class FlumeEventAvroServerImpl implements FlumeEventAvroServer {
  private HttpServer http;
  private final int port;

  /**
   * This just sets the port for this AvroServer
   */
  public FlumeEventAvroServerImpl(int port) {
    this.port = port;
  }

  /**
   * This blocks till the server starts.
   */
  public void start() throws IOException {
    SpecificResponder res = new SpecificResponder(FlumeEventAvroServer.class,
        this);
    this.http = new HttpServer(res, port);
    this.http.start();
  }

  @Override
  public void append(AvroFlumeEvent evt) {
  }

  /**
   * Stops the FlumeEventAvroServer, called only from the server.
   */
  public void close() throws AvroRemoteException {
    http.close();
  }
}
