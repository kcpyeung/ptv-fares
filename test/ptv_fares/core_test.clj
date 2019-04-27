(ns ptv-fares.core-test
  (:require [clojure.test :refer :all]
            [ptv-fares.core :refer :all]))

(deftest myki-pass-starts-on-monday-and-ends-on-sunday
  (testing "actual days used will be only weekdays"
           (is (= 20 (used-days 28)))))
