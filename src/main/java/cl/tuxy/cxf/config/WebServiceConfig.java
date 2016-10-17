/**
 * Copyright (C) 2016  Jose P. Bovet Derpich (jose.bovet@gmail.com)
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cl.tuxy.cxf.config;

import cl.tuxy.cxf.service.UserService;
import cl.tuxy.cxf.service.UserServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import javax.xml.ws.Endpoint;

/**
 * Created by josebovet on 10/17/16.
 */
@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;


    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public Endpoint userServiceEndPoint() {
        EndpointImpl userServiceEndPoint = new EndpointImpl(bus, userService());
        userServiceEndPoint.setAddress("/UserService");
        userServiceEndPoint.publish();
        return userServiceEndPoint;
        // <jaxws:endpoint id="userService"  implementor="cl.tuxy.cxf.service.UserServiceImpl" address="/UserService" />
    }


    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2)
                .addScript("import.sql")
                .build();
        return db;
    }

}
