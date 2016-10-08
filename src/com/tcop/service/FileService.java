package com.tcop.service;

import java.util.List;
import com.tcop.FileInfo;
import com.tcop.FileInfo.FileType;
import com.tcop.FileInfo.OrderType;
import org.springframework.web.multipart.MultipartFile;

public abstract interface FileService
{
  public abstract boolean isValid(FileInfo.FileType paramFileType, MultipartFile paramMultipartFile);
  
  public abstract String upload(FileInfo.FileType paramFileType, MultipartFile paramMultipartFile, boolean paramBoolean);
  
  public abstract String upload(FileInfo.FileType paramFileType, MultipartFile paramMultipartFile);
  
  public abstract String uploadLocal(FileInfo.FileType paramFileType, MultipartFile paramMultipartFile);
  
  public abstract List<FileInfo> browser(String paramString, FileInfo.FileType paramFileType, FileInfo.OrderType paramOrderType);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.FileService
 * JD-Core Version:    0.7.0.1
 */