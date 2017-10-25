/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.artemis.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.apache.activemq.artemis.core.buffers.impl.ChannelBufferWrapper;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ChannelBufferWrapperTest {


   @Test
   public void testOutOfBoundsThrownOnMalformedString() {
      ByteBuf byteBuffer = ByteBufAllocator.DEFAULT.buffer(4);
      byteBuffer.writeInt(100);

      Exception e = null;
      try {
         ChannelBufferWrapper cbw = new ChannelBufferWrapper(byteBuffer);
         cbw.readSimpleString();
      } catch (IndexOutOfBoundsException iob) {
         e = iob;
      }
      assertTrue(e instanceof IndexOutOfBoundsException);
   }

}
