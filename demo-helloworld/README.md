## Maven

## Lombok
-- 1. Project -> maven (pom.xml) -> add a new dependency (lombok)
-- 2. mvn compile -> download classes (Getter, Setter, ToString, etc)
-- 3. Inject all those classes into your maven project
-- 4. Annotate @Getter in your class -> import those classes into your class

## Java Comile-time vs Lombok
-- Java doesn't understand the meaning of Annotations (i.e. @Getter)
-- Lombok is an external Library that teaches Java Compiler how to convert to Java code before compile
-- target > classes > Person1.class -> Decompile