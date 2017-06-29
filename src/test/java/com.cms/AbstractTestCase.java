package com.cms;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: wanliLuo
 * Date: 2016-12-18
 * Time: 14:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-mvc*.xml"})
public class AbstractTestCase extends TestCase {
}
