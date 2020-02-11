package com.chubin.simple.spring.metadata;

import java.io.IOException;

import com.chubin.simple.spring.io.MetadataReader;
import com.chubin.simple.spring.io.Resource;

public interface MetadataReaderFactory {
  
	 MetadataReader getMetadataReader(String className) throws IOException;
	 
	 MetadataReader getMetadataReader(Resource  resource) throws IOException;
	
}
