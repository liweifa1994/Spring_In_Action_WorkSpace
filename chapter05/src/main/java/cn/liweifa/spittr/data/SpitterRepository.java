package cn.liweifa.spittr.data;


import cn.liweifa.spittr.pojo.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
