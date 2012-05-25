/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.handler.codec.spdy;


import io.netty.channel.ChannelBootstrap;
import io.netty.channel.ServerChannelBootstrap;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.nio.SelectorEventLoop;
import io.netty.channel.socket.oio.BlockingChannelEventLoop;
import io.netty.channel.socket.oio.OioServerSocketChannel;

public class NioOioSocketSpdyEchoTest extends AbstractSocketSpdyEchoTest {

    @Override
    protected ChannelBootstrap newClientBootstrap() {
        return new ChannelBootstrap()
                .eventLoop(new SelectorEventLoop())
                .channel(new NioSocketChannel());
    }

    @Override
    protected ServerChannelBootstrap newServerBootstrap() {
        return new ServerChannelBootstrap()
                .eventLoop(new BlockingChannelEventLoop(), new BlockingChannelEventLoop())
                .channel(new OioServerSocketChannel());
    }
}
