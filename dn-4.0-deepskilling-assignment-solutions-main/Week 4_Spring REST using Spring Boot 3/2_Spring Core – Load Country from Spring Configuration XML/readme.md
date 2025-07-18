##  Objective

- Configure a country bean using `country.xml`.
- Load the bean using `ApplicationContext`.
- Use logging to trace constructor and property method calls.
- Demonstrate understanding of Spring bean lifecycle and XML configuration.


## 🧾 Configuration File: `country.xml`

Located in: `src/main/resources/country.xml`

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
         http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="country" class="com.cognizant.springlearn.Country">
        <property name="code" value="IN" />
        <property name="name" value="India" />
    </bean>

</beans>
