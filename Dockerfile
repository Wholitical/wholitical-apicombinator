FROM java:8

ADD entrypoint.sh /

ADD build/libs/apicombinator-0.0.1-SNAPSHOT.jar /

EXPOSE 8080

ENTRYPOINT ["/entrypoint.sh"]