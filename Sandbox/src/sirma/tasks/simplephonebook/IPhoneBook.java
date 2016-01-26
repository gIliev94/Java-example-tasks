package sirma.tasks.simplephonebook;

/**
 * Interface describing core behavior of a {@link SimplePhoneBook}.
 * 
 * @author Georgi Iliev
 *
 */
public interface IPhoneBook {

    /**
     * Stores a contact into the phone book.
     * 
     * @param contact
     *            - the contact to be saved.
     * @return TRUE if saving passes, FALSE if it fails.
     */
    boolean save(Contact contact);

    /**
     * Deletes the contact with the same ID as the provided parameter.
     * 
     * @param id
     *            - the id of the contact to be deleted.
     * @return TRUE if the contact is found and deleted, FALSE if it isn`t
     *         present.
     */
    boolean delete(int id);

    /**
     * Prints out a listing of:
     * <p>
     * - All contacts, if {@code column} is not set;
     * </p>
     * <p>
     * - Filtered by column value list of contacts, if {@code column} is set.
     * </p>
     * 
     * @param column
     *            - column according to which the contacts are filtered.
     */
    void list(String column);

}
