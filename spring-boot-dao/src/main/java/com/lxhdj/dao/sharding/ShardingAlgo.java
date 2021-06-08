package com.lxhdj.dao.sharding;

import com.alibaba.fastjson.JSON;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;


public class ShardingAlgo implements PreciseShardingAlgorithm<String> {
    public static final int MAX_SPIT_TABLE = 2;

    @Override
    public String doSharding(Collection<String> availableTargetNames,
                             PreciseShardingValue<String> shardingValue) {
        System.out.println("shardingValue===============" + JSON.toJSONString(shardingValue));
        return shardingValue.getLogicTableName() + "_" + getHashIndex(shardingValue.getValue());
    }

    public static int getHashIndex(String str) {
        int hash = str.hashCode();
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash % MAX_SPIT_TABLE;
    }
}
