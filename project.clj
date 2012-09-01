(defproject ritz "0.4.0-SNAPSHOT"
  :description "Another swank server for clojure in SLIME"
  :url "https://github.com/pallet/ritz"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/main/clojure"]
  :resources-paths ["src/main/resources"]
  :test-paths ["src/test/clojure"]
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojure/data.codec "0.1.0"]
                 [org.clojure/tools.nrepl "0.2.0-beta9"]
                 [ritz/repl-utils "0.4.0-SNAPSHOT"]]
  :profiles {:it {:source-paths ["src/main/clojure" "src/it/clojure"]
                  :dependencies [[org.palletops/clojure "1.3.0-p1"]
                                 [org.cloudhoist/pallet "0.6.7"]
                                 [org.cloudhoist/automated-admin-user "0.6.0"]
                                 [org.cloudhoist/git "0.5.0"]
                                 [org.cloudhoist/java "0.5.1"]
                                 [org.cloudhoist/pallet-lein "0.4.1"]
                                 [org.slf4j/slf4j-api "1.6.1"]
                                 [ch.qos.logback/logback-core "1.0.0"]
                                 [ch.qos.logback/logback-classic "1.0.0"]
                                 [vmfest "0.2.3"]
                                 [org.clojure/clojure-contrib "1.2.0"]]
                  :repositories
                  {"sonatype"
                   "https://oss.sonatype.org/content/repositories/releases/"}}
             :dev {:dependencies [[leiningen "2.0.0-preview10"]]}}
  :jvm-opts ["-Djava.awt.headless=true"]
  :sub ["repl-utils" "debugger" "nrepl" "swank"]
  :plugins [[lein-sub "0.2.0"]])
