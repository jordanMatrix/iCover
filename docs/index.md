# iCover
Enable generating code coverage for server side (integration) tests concisely. Concisely means coverage data is separated
* from non-test traffic,
* by test runs and
* by test case.

In many instances broader integration tests (aka "end-to-end tests") are run with the software deployed server side (or serverless-side), i.e. in a "real" environment with actual remote dependencies running and with a port to listen on or being triggerable as in production. This project addresses the need to also have code coverage data collected and visible for those. A lot of times coverage data for those kind of tests is lacking. If you have none of these type of tests, you can stop reading. This project will most likely not help you.

The label used before "integration test" is just that - a label. We believe all coverage data should be analyzed to finally evaluate the confidence level of your tests - whether you call them "unit tests", "integration tests", "end to end tests" etc. Moreover, we share [Martin Fowler's opinion](https://martinfowler.com/bliki/TestCoverage.html) that code coverage in percentage is more about what you have _not_ covered and if you are happy about the uncovered part / risk implied. In that spirit in a very late stage of this project, we want to offer a better visualization of the covered code akin to a Tree Map visualization with partial subtrees. This will enable much better and more conscious decisions rather than just relying on a two digit percentage value to judge the quality and confidence level of the tests.

We have had some critical discussions about whether enabling gathering coverage for these type of tests might actually be harmful rather than useful because it might give a false sense of security because either not all side-effects of all statements have been asserted or it might result in an "over reliance" on integration / end-2-end tests with too little unit tests. This project will provide a tool and like any tool it can be abused or used unintentionally. Whether it is the right tool or not can only be decided by the user in their specific usage context. An "over reliance" on integration tests over unit tests is again a [labeling issue](https://martinfowler.com/bliki/IntegrationTest.html). There also seems to be a growing trend to shift the valuation of traditional test pyramid towards a ["testing honeycomb"](https://engineering.atspotify.com/2018/01/11/testing-of-microservices/) in certain contexts, also a [more opinionated](https://medium.com/@mateuszroth/why-the-test-pyramid-is-a-bullshit-guide-to-testing-towards-modern-frontend-and-backend-apps-4246e89b87bd) but good overview. The discussion about not having covered all side-effects is a trickier one. Altogether, we believe being able to measure test coverage where it was previously not enabled will be more useful than remaining without the coverage data ("blind"). 

## Features
Currently, most of the features listed here are not implemented, yet. So take this more as a pitch and vision. Also, you can [add feature requests](https://github.com/jordanMatrix/iCover/issues/new/choose) of things you would like to see and find useful.

### Leverage standard coverage measurement tooling
Measuring code coverage has well established libraries and solutions already. Currently, we are leveraging [JaCoCo](https://www.jacoco.org/jacoco/) for code coverage measurement. If over time it becomes evident that JaCoCo does not work well in some situations, we will try to integrate other alternatives for those scenarios.

### Reliably detect test traffic
There are several methods by which test traffic can be detected: the presence of a specific HTTP header, a specific or pattern-matching HTTP header value, a source IP (range) and other plugable mechanisms can be implemented. We provide default implementations for common test traffic detection use cases and allow new custom detection method implementations by providing a clean interface based plugability mechanism.

### Group together coverage for different test runs
Depending on configuration coverage data can be automatically grouped by different test runs. This can be achieved by either pulling the coverage data and reseting it thereafter (supported out of the box by JaCoCo) or providing easily configurable standard test run detection implementations (HTTP header value (pattern), time interval based). The same extensibility that is provided for test traffic detection applies here as well.

### Plugable Configuration
The configuration of the library can be done using a standard YAML / property file resource path discovery mechanism or via a provided custom implementation of a configuration source. As over time some "custom" implementations become common, we will provide them as default implementations for everyone to use. We will make as little as possible assumptions on your system setup / integration. Hence, the library should be easily integrate-able into most system / cloud setups.

### Supports a push and pull model for coverage data gathering
In some system contexts a push model and in some contexts a pull model will be more appropriate. JaCoCo supports both approaches out of the box. We offer a very thin convenience layer on top of what JaCoCo offers.

### "Live" test run coverage data
As a test run is underway the library can be configured to push data out as it collects it and so enable life (near real time) observation in coverage data during actual test execution. The actual visualization needs integration-side implementation and is not provided out of the box.

### Serverless integration
The project and library implementation have been done with an integration into a serverless environment as a first class citizen in mind. Integration facilities provided are as seamless for serverless as they are for classical server environments.

<!---
## Main challenges and how we solved them
Here we briefly introduce what the main challenges are / were in realizing the above goal and how we solved them. This section is work in progress and will be updated over time with progress.


### Detect test traffic
* How? Request ID, some other header / content?
* Source IP filtering?
* Make mechanism pluggable / extensible to allow providing an own impl

### Reset and group together coverage for different test runs
* When is a test run finished?? Hard to say automagically…
* Per test case / suite coverage resolution

### Produce coverage results for on-going test runs

### Submit coverage data
* Where? How?

### Serverless?
* All of the above how?

### Make configuration pluggable
* supplied implementations: simple file based, some Spring-repo-based
-->
<br/>
<sub>... boldly go where no one has gone before.</sub>
