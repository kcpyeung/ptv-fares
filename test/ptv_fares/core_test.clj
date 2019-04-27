(ns ptv-fares.core-test
  (:require [clojure.test :refer :all]
            [ptv-fares.core :refer :all]))

(deftest myki-pass-starts-on-monday-and-ends-on-sunday
  (testing "actual days used will be only weekdays"
           (is (= 20 (used-days 28)))))

(deftest myki-pass-starts-on-monday-and-ends-on-weekday
  (testing "actual days used will be weekdays in the full weeks, plus weekdays in the partial week"
           (is (= 21 (used-days 29)))
           (is (= 22 (used-days 30)))
           (is (= 23 (used-days 31)))
           (is (= 24 (used-days 32)))
           (is (= 25 (used-days 33)))))
