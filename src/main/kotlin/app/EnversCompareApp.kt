package app

import org.springframework.beans.factory.FactoryBean
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication
@EnableJpaRepositories("app.*", repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean::class)
    @ComponentScan
    @EntityScan
    open class EnversCompareApp{

    }

    fun main(args: Array<String>) {
        SpringApplication.run(EnversCompareApp::class.java, *args)
    }