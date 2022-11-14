package com.znczCxtc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public interface RglrSfzhJiLuService {

	List<String> queryXzSfzhCBBList(int page, int rows, String sort, String order);

}
