# SOFTENG283 CI and flaky tests demo

This Maven demo lives in the `demo-ci-flaky-seat-reservations/` subfolder of the demos repository. It uses event seat reservations to demonstrate shared test state, uncontrolled randomness, Mockito, and GitHub Actions.

## Demo steps

1. Put the workflow below at the repository root as `.github/workflows/ci.yml`. This demo repository already has that file. Commit and push it to `main`.
2. Check the **Actions** tab. The tests are intentionally flaky: the run may fail or pass. If it passes, rerun it.
3. In the demo subfolder, run `./mvnw test` and fix the test-order dependency by giving each test a fresh `SeatAllocator`.
4. Use Mockito to control the `Random` input in the remaining flaky test. Push the fixes and confirm that CI passes repeatedly.

## `.github/workflows/ci.yml`

Copy this file into the repository root, not into the demo subfolder:

```yaml
name: Seat Reservation CI Demo

on:
  push:
    branches: [main]
  pull_request:
    branches: [main]

permissions:
  contents: read

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - name: Check out the repository
        uses: actions/checkout@v6

      - name: Set up Java 21
        uses: actions/setup-java@v6
        with:
          distribution: temurin
          java-version: '21'
          cache: maven

      - name: Run tests with Maven Wrapper
        working-directory: demo-ci-flaky
        run: ./mvnw --batch-mode test
```

For the random-seat test, mock `Random`, stub `nextInt(2)` to return `0`, then assert that `A1` is reserved. The demo project has the JUnit and Mockito dependencies in its `pom.xml`.
