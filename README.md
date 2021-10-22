# iCover
Enable generating code coverage for server side (integration) tests concisely. Concisely means coverage data is separated
* from non-test traffic,
* by test runs and
* by test case.

In many instances broader integration tests (aka "end-to-end tests") are run with the software deployed server side (or serverless-side), i.e. in a "real" environment with actual remote dependencies running and with a port to listen on or being triggerable as in production. This project addresses the need to also have code coverage data collected and visible for those. A lot of times coverage data for those kind of tests is lacking. If you have none of these type of tests, you can stop reading. This project will most likely not help you.

The label used before "integration test" is just that - a label. We believe all coverage data should be analyzed to finally evaluate the confidence level of your tests - whether you call them "unit tests", "integration tests", "end to end tests" etc. Moreover, we share [Martin Fowler's opinion](https://martinfowler.com/bliki/TestCoverage.html) that code coverage in percentage is more about what you have _not_ covered and if you are happy about the uncovered part / risk implied. In that spirit in a very late stage of this project, we want to offer a better visualization of the covered code akin to a Tree Map visualization with partial subtrees. This will enable much better and more conscious decisions rather than just relying on a two digit percentage value to judge the quality and confidence level of the tests.

We have had some critical discussions about whether enabling gathering coverage for these type of tests might actually be harmful rather than useful because it might give a false sense of security because either not all side-effects of all statements have been asserted or it might result in an "over reliance" on integration / end-2-end tests with too little unit tests. This project will provide a tool and like any tool it can be abused or used unintentionally. Whether it is the right tool or not can only be decided by the user in their specific usage context. An "over reliance" on integration tests over unit tests is again a [labeling issue](https://martinfowler.com/bliki/IntegrationTest.html). There also seems to be a growing trend to shift the valuation of traditional test pyramid towards a ["testing honeycomb"](https://engineering.atspotify.com/2018/01/11/testing-of-microservices/) in certain contexts, also a [more opinionated](https://medium.com/@mateuszroth/why-the-test-pyramid-is-a-bullshit-guide-to-testing-towards-modern-frontend-and-backend-apps-4246e89b87bd) but good overview. The discussion about not having covered all side-effects is a trickier one. Altogether, we believe being able to measure test coverage where it was previously not enabled will be more useful than remaining without the coverage data ("blind"). 

## Features

 

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

<br/>
<sub>... boldly go where no one has gone before.</sub>
