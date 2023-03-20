package com.example.srp.netty;

import io.netty.handler.ipfilter.IpFilterRule;
import io.netty.handler.ipfilter.IpFilterRuleType;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;

public class MyIpFilterRule implements IpFilterRule {
    private static Set<String> ipSet = new HashSet<>();

    static {
        ipSet.add("112.96.116.154");
        ipSet.add("127.0.0.1");
        ipSet.add("221.4.34.212");
        ipSet.add("117.136.32.99");
        // System.out.println(ipSet);
    }


    @Override
    public boolean matches(InetSocketAddress inetSocketAddress) {
        String ip = inetSocketAddress.getAddress().toString();
        if (ip.charAt(0) == '/') ip = ip.substring(1);
        return !ipSet.contains(ip);
    }

    @Override
    public IpFilterRuleType ruleType() {
        return IpFilterRuleType.REJECT;
    }
}
