(ns ptv-fares.days-test
  (:require [clojure.test :refer :all]
            [ptv-fares.days :refer [used-days]]))

(deftest actual-used-days-will-be-weekdays
  (testing "starting on Monday and ending on Sunday"
           (is (= 25 (used-days 35))))

  (testing "starting on Monday and ending on Saturday"
           (is (= 25 (used-days 34))))

  (testing "starting on Monday and ending on Friday"
           (is (= 25 (used-days 33)))))

(deftest myki-pass-starts-on-monday-and-ends-on-weekday
  (testing "actual days used will be weekdays in the full weeks, plus weekdays in the partial week"
           (is (= 21 (used-days 29)))
           (is (= 22 (used-days 30)))
           (is (= 23 (used-days 31)))
           (is (= 24 (used-days 32)))
           (is (= 25 (used-days 33)))))
