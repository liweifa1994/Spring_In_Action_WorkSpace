package cn.liweifa.spittr.data;

import cn.liweifa.spittr.pojo.*;
import java.util.List;


public interface SpittleRepository {

  List<Spittle> findRecentSpittles();

  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
