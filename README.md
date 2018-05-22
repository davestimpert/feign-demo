# feign-demo
This repo was made to demonstrate how to define a header value on a feign client in a spring boot app

## Goal
Create a feign client in a spring boot app that has a header on every request.  Ideally the header is specified on the
interface itself rather than the individual methods, because we want to configure the header globally for the client
rather than making all the calling code responsible for providing the header.  (This header is authentication-related)
