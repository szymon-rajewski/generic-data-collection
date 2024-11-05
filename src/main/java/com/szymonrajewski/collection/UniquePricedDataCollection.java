package com.szymonrajewski.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UniquePricedDataCollection<ElementType extends UniqueElement & PricedElement> implements DataCollection<ElementType> {
    private final int INITIAL_SIZE = 10;
    private Object[] elements;
    private int elementCount;

    public UniquePricedDataCollection() {
        this.elements = new Object[this.INITIAL_SIZE];
        this.elementCount = 0;
    }

    public void add(Optional<ElementType> element) throws InvalidCollectionElementException {
        if (element.isEmpty()) {
            throw new InvalidCollectionElementException("Element not present");
        }

        if (this.elementCount == this.elements.length) {
            this.increaseSize();
        }
        int insertIndex = this.elementCount;
        this.elements[insertIndex] = element.get();
        this.elementCount++;
    }

    public void remove(Optional<ElementType> element) throws InvalidCollectionElementException, NotFoundCollectionElementException {
        if (element.isEmpty()) {
            throw new InvalidCollectionElementException("Element not present");
        }

        Optional<Integer> indexToRemove = this.findIndex(element.get());
        if (indexToRemove.isEmpty()) {
            throw new NotFoundCollectionElementException("Element not found");
        }

        this.removeElement(indexToRemove.get());
    }

    public int count() {
        return this.elementCount;
    }

    @SuppressWarnings("unchecked")
    public Map<String, ElementType> getElementWithLowestPrice() {
        float lowestPrice = 0;

        for (int index = 0; index < this.elementCount; index++) {
            ElementType element = (ElementType) this.elements[index];

            boolean isPriceLower = element.price() < lowestPrice;
            if (lowestPrice == 0 || isPriceLower) {
                lowestPrice = element.price();
            }
        }
        return this.findElementsByPrice(lowestPrice);
    }

    @SuppressWarnings("unchecked")
    private Optional<Integer> findIndex(ElementType element) {
        int indexToRemove = -1;
        for (int i = 0; i < this.elementCount; i++) {
            ElementType uniqueElement = (ElementType) this.elements[i];
            if (uniqueElement.id().equals(element.id())) {
                indexToRemove = i;
                break;
            }
        }
        return indexToRemove < 0 ? Optional.empty() : Optional.of(indexToRemove);
    }

    private void removeElement(int indexToRemove) {
        int updatedSize = this.elements.length - 1;
        this.shiftElements(indexToRemove, updatedSize);
        this.elements[updatedSize] = null;
        this.elementCount--;
    }

    private void shiftElements(int indexToRemove, int updatedSize) {
        for (int index = indexToRemove; index < updatedSize; index++) {
            this.elements[index] = this.elements[index + 1];
        }
    }

    private void increaseSize() {
        this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    @SuppressWarnings("unchecked")
    private Map<String, ElementType> findElementsByPrice(float price) {
        Map<String, ElementType> elements = new HashMap<>();

        for (int index = 0; index < this.elementCount; index++) {
            ElementType element = (ElementType) this.elements[index];

            boolean isPriceEqual = price == element.price();
            if (isPriceEqual) {
                elements.put(element.id(), element);
            }
        }
        return elements;
    }
}
