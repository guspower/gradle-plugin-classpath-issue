package org.gradle

import spock.lang.Specification

class PluginClasspathSpec extends Specification {

    def "servlet api comes from specified dependency location"() {
      given:
          Class clazz = Class.forName("javax.servlet.http.HttpServletRequest")
          URL source = clazz.classLoader.getResource("javax/servlet/http/HttpServletRequest.class")
      expect:
          !source.path.contains('gradle-api')
    }

}
