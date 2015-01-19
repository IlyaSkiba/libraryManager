package by.library.services.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration required for collaboration with H2 database and indexing an archive.
 *
 * @author Ilya Skiba
 */
@Configuration
@ComponentScan(basePackages = "by.library")
public class SpringConfiguration {
}
