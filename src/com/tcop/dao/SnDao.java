package com.tcop.dao;

import com.tcop.entity.Sn;

public abstract interface SnDao
{
  public abstract String generate(Sn.Type paramType);
}