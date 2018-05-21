# feign-demo
This repo was made to demonstrate what might be a limitation of the Feign Client in Spring Boot apps

## Goal
Create a feign client in a spring boot app that has a header on every request.  Ideally the header is specified on the
interface itself rather than the individual methods, because we want to configure the header globally for the client
rather than making all the calling code responsible for providing the header.  (This header is authentication-related)

## Problem
I currently have the `RequestInterceptor` defined as a bean.  This is not ideal because if I were to add another Feign client
to the same application, it would unwantingly get the same request header.

### Solution 1
I could create the client using the `Feign.builder`, however this has a few drawbacks:

1. It uses a different contract than the `SpringMvcContract`, so I need to specify that in order to use the same annotations
2. It seems I also need to then define my own decoder and encoder.  
3. I can no longer use the url defined in the `@FeignClient` annotation

### Solution 2
I could define a configuration class for the `FeignClient`, but this has a drawback:

1. The documentation states that this must be annotated with `@Configuration`, but NOT component scanned, or it will be picked
up for all clients.  This seems error prone
