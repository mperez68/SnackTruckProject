# Zonar Systems Snack Truck Homework

This project was developed with:

Android Studio Bumblebee | 2021.1.1 Patch 1
Build #AI-211.7628.21.2111.8139111, built on February 1, 2022
Runtime version: 11.0.11+9-b60-7590822 amd64
VM: OpenJDK 64-Bit Server VM by Oracle Corporation
Windows 10 10.0
GC: G1 Young Generation, G1 Old Generation
Memory: 1280M
Cores: 4
Registry: external.system.auto.import.disabled=true
Non-Bundled Plugins: org.jetbrains.kotlin (211-1.6.10-release-923-AS7442.40), com.jetbrains.kmm (0.3.1(211-1.6.10-release-960-IJ)-89)

# Test Plan

## SCOPE

The scope of this project is entirely local with mock data for what can be information aquired from a database. All testing should be conducted assuming that data used is dynamic and is not guaranteed to be consistent moment to moment.


## GOAL

The quality goals of testing this project are such that it needs to work consistently and fluidly for a given user. The target user is the general public which means that no expectation of tech literacy should be expected. Further, usage of accessibility functions within the Android system should be expected and accounted for.

It can be assumed that installation/updating the application is handled by employees with a stronger skillset and is less urgent in general.

## TEST METHODOLOGY

By nature of being a customer facing application, it should be considered when testing UI elements such as button presses that all possible interactions (each clickable button on the screen, for example) and any combination/order of interactions is investigated.

The business logic of this application should check for the robustness of all public functions of the classes involved. Each test should consider edge cases, large amounts of data, and out-of-bounds inputs as well as ambiguous or non-primitive invalid data (such as integers representing color codes that are given input that is not a color code).

## TESTING PRIORITIES/TOOLS

In order of importance:
Functional Testing (Unit Testing)
UI Testing (Espresso)
Compatibility Testing (Android Studio CTS)
Performance Testing (Android Studio Profiler)
Interupt Testing (Unit Testing)

(https://www.guru99.com/test-plan-for-project.html and https://www.softwaretestinghelp.com/android-app-testing/#1_Functional_Testing used for reference in developing a test plan.)
