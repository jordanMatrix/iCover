# iCover
Enable generating code coverage for server side (integration) tests concisely. Concisely means coverage data is separated
* from non-test traffic,
* by test runs and
* by test case.

In many instances broader integration tests (aka "end-to-end tests") are run with the software deployed server side (or serverless-side), i.e. in a "real" environment with actual remote dependencies running and with a port to listen on or being triggerable as in production. This project addresses the need to also have code coverage data collected and visible for those. A lot of times coverage data for those kind of tests is lacking. Since there is a growing trend / shift towards more 

## Main challenges and how we solved them
Here we briefly introduce what the main challenges are / were in realizing the above goal.


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


<!---
You can use the [editor on GitHub](https://github.com/jordanMatrix/iCover/edit/main/docs/index.md) to maintain and preview the content for your website in Markdown files.

Whenever you commit to this repository, GitHub Pages will run [Jekyll](https://jekyllrb.com/) to rebuild the pages in your site, from the content in your Markdown files.

### Markdown

Markdown is a lightweight and easy-to-use syntax for styling your writing. It includes conventions for

```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3

- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```

For more details see [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/).

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in your [repository settings](https://github.com/jordanMatrix/iCover/settings/pages). The name of this theme is saved in the Jekyll `_config.yml` configuration file.

### Support or Contact

Having trouble with Pages? Check out our [documentation](https://docs.github.com/categories/github-pages-basics/) or [contact support](https://support.github.com/contact) and we’ll help you sort it out.

-->
