package com.caoruiqun.redis.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * @author 茆永强
 * @date 2022-10-10 9:30
 */

public class ModelMapperUtil {

    public static ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        //默认标准匹配策略有问题
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

//    //方法有问题
//    public static <T> List<T> copyProperties(List sourceList, T t) {
//        ModelMapper modelMapper = ModelMapperUtil.getModelMapper();
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        List<T> returnList = modelMapper.map(sourceList, new TypeToken<List<T>>() {
//        }.getType());
//        return returnList;
//    }

}
