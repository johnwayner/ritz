(ns ritz.nrepl.middleware.simple-complete-test
  (:use
   [clojure.java.io :only [file]]
   [clojure.string :only [split-lines]]
   [clojure.test :only [deftest is testing]]
   [ritz.nrepl.middleware.simple-complete :only [simple-complete-reply]]
   [ritz.nrepl.middleware.test-transport :only [test-transport messages]]))

(deftest simple-complete-test
  (testing "no match"
    (let [t (test-transport)]
      (simple-complete-reply
       {:transport t :symbol "this-doesnt-exit"
        :ns "ritz.nrepl.middleware.doc"})
      (is (= [{:value '(nil "this-doesnt-exit")}
              {:status #{:done}}] (messages t)))))
  (testing "match"
    (let [t (test-transport)]
      (simple-complete-reply
       {:transport t :symbol "ns-resolve" :ns "clojure.core"})
      (is (= [{:value '(("ns-resolve") "ns-resolve")}
              {:status #{:done}}]
             (messages t))))))
