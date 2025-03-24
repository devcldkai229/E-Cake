function changeIonIconName(id, newName) {
    // Lấy thẻ ion-icon bằng ID
    const icon = document.getElementById(id);

    // Thay đổi thuộc tính 'name' của thẻ ion-icon
    if (icon) {
        icon.setAttribute('name', newName);
    }
}
// Function to toggle visibility of sections with smooth transition
function toggleSection(sectionId, dropdownId) {
    const section = document.getElementById(sectionId);

    // Kiểm tra xem phần tử đã có class 'hidden' chưa
    if (section.classList.contains('hidden')) {
        section.classList.remove('hidden');
    } else {
        section.classList.add('hidden');
    }

    const icon = document.getElementById(dropdownId);
    changeIonIconName(dropdownId, icon.getAttribute('name') === 'chevron-back' ? 'chevron-down' : 'chevron-back');
}