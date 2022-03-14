package com.example.demo;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.StopWatch;
import cn.hutool.core.io.file.PathUtil;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.CharsetUtil;
import lombok.extern.java.Log;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.controller.Student;
import com.fasterxml.jackson.core.io.CharTypes;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

@Log
// @SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test() {

		StopWatch stopWatch = new StopWatch();
		stopWatch.start("生成SQL");

		Context context = Context.enter();
		LineNumberReader reader = null;

		try {
			Scriptable scope = context.initStandardObjects();

			Student students = new Student();
			students.setAge(23);
			students.setName("Yves");
			Object jsObj = Context.javaToJS(students, scope);
			ScriptableObject.putProperty(scope, "student", jsObj);
			
			
			List<Integer> ids = new ArrayList<>();
			ids.add(1);
			ids.add(2);
			// int[] ids = new int[]{1,2}; // 直接声明数组也是可以的

			// Object idsObj = Context.javaToJS(ids, scope);
			ScriptableObject.putProperty(scope, "ids", ids.toArray());
			// ScriptableObject.putProperty(scope, "ids", null);
		
			// 传递布尔值
			ScriptableObject.putProperty(scope, "isOk", false);

		
			BufferedReader fileReader = ResourceUtil.getReader("static/sql.js", CharsetUtil.CHARSET_UTF_8);
			reader = new LineNumberReader(fileReader);

			String temp = null;

			StringBuffer sb = new StringBuffer();
			while ((temp = reader.readLine()) != null) {
				sb.append(temp).append("\n");
			}

			context.evaluateString(scope, sb.toString(), null, 1, null);

			
	
			for (int i = 0; i < 200; i++) {
				// context.evaluateString(scope, "selectArg([1,2]);", null, 1, null);
				// context.evaluateString(scope, "selectArg();", null, 1, null);
				context.evaluateString(scope, "select();", null, 1, null);				
			}
			
			// log.info(Context.toString(result));
			stopWatch.stop();

			// Object result = context.evaluateString(scope, "select();", null, 1, null);

			log.info("共计" + stopWatch.getTotalTimeSeconds() + "秒");
			log.info(stopWatch.prettyPrint());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Context.exit();
		}
	}

}
